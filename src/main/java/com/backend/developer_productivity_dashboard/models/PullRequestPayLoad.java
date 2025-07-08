package com.backend.developer_productivity_dashboard.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document("pull-requests")
public class PullRequestPayLoad {
    // Model for pull request event

    private String action;
    private int number;
    @JsonProperty("pull_request")
    private PullRequest pullRequest;
    private Repository repository;

    @Data
    public static class Organization {
        private String name, full_name;
        private Owner owner;
    }

    @Data
    public static class Repository {
        private String name, full_name;
        private Owner owner;
    }

    @Data
    public static class Owner {
        private String login;
    }

    @Data
    public static class PullRequest {
        private long id;
        private String title;
        private String body;
        private String state;
        private boolean merged;
        @JsonProperty("merge_commit_sha")
        private String mergeCommitSha;
        @JsonProperty("created_at")
        private Instant createdAt;
        @JsonProperty("updated_at")
        private Instant updatedAt;
        @JsonProperty("closed_at")
        private Instant closedAt;
        @JsonProperty("merged_at")
        private Instant mergedAt;
        private UserLogin user;
        private Head head;
        private Base base;
        private int commits;

        private int additions;
        private int deletions;
        @JsonProperty("changed_files")
        private int changedFiles;
        private Organization organization;
    }

    @Data
    public static class UserLogin {
        private String login;
    }

    @Data
    public static class Head {
        private String ref, sha;
    }

    @Data
    public static class Base {
        private String ref, sha;
    }

}
