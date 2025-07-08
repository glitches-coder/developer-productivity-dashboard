package com.backend.developer_productivity_dashboard.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PushPayLoad {
    private String ref;
    private Pusher pusher;
    private Repository repository;
    private List<Commits> commits;


    @Data
    public static class Pusher {
        @JsonProperty("name")
        private String name;
    }

    @Data
    public static class Repository {
        @JsonProperty("name")
        private String repoName;
    }

    @Data
    public static class Commits {
        private String id, message, url, distinct;
        @JsonProperty("timestamp")
        private Date timeStamp;
        private Author author;
        private Committer committer;

    }

    @Data
    public static class Author {
        private String name, email, username;
    }

    @Data
    public static class Committer {
        private String name, email, username;
    }

}
