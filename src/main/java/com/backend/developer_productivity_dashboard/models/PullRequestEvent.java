package com.backend.developer_productivity_dashboard.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document("pull-requests")
public class PullRequestEvent {
    @Id
    private String id;

    private long pullRequestId;
    private String action;
    private int number;
    private String title;
    private String body;
    private String state;
    private boolean merged;
    private String mergeCommitSha;

    private Instant createdAt;
    private Instant updatedAt;
    private Instant closedAt;
    private Instant mergedAt;

    private String authorLogin;
    private String headRef;
    private String headSha;
    private String baseRef;
    private String baseSha;

    private int commits;
    private int additions;
    private int deletions;
    private int changedFiles;

    private String repoName;
    private String repoFullName;
    private String repoOwner;

    private String organization;
}
