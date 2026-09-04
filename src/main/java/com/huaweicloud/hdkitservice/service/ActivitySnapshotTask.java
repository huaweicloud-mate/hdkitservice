package com.huaweicloud.hdkitservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.huaweicloud.hdkitservice.model.ActivityStatsSnapshot;
import com.huaweicloud.hdkitservice.repository.ActivityStatsSnapshotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class ActivitySnapshotTask {

    private static final Logger log = LoggerFactory.getLogger(ActivitySnapshotTask.class);

    private static final String API_URL = "https://open-dataset.huaweicloud.com/api/v1/hdopenservice/servlet/activity-stats";
    private static final String ACTIVITY_CODE = "open-capability-2026";

    private final RestTemplate restTemplate;
    private final ActivityStatsSnapshotRepository snapshotRepo;

    public ActivitySnapshotTask(ActivityStatsSnapshotRepository snapshotRepo) {
        this.snapshotRepo = snapshotRepo;
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(cron = "0 0 6 * * *")
    public void captureSnapshot() {
        try {
            String url = API_URL + "?activity_code=" + ACTIVITY_CODE;
            ResponseEntity<JsonNode> resp = restTemplate.getForEntity(url, JsonNode.class);
            JsonNode data = resp.getBody().get("data");

            LocalDate today = LocalDate.now();
            ActivityStatsSnapshot snapshot = new ActivityStatsSnapshot(
                    today,
                    data.get("activity_code").asText(),
                    data.get("activity_name").asText(),
                    data.get("participant_count").asInt(),
                    data.get("submit_count").asInt(),
                    data.get("beginner_count").asInt(),
                    data.get("intermediate_count").asInt(),
                    data.get("advanced_count").asInt()
            );

            snapshotRepo.save(snapshot);
            log.info("[activity-snapshot] saved for {}", today);
        } catch (Exception e) {
            log.error("[activity-snapshot] failed: {}", e.getMessage(), e);
        }
    }
}
