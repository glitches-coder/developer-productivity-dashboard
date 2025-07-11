Repository for developer-productivity-dashboard

## Architecture Flow

```mermaid
%%{init: {"flowchart": {"htmlLabels": true}}}%%
flowchart TB
  FE["Frontend<br/>React/Angular"]
  SB["Spring Boot Monolith"]
  PY["Python FastAPI"]
  DB["MongoDB"]

  FE --> SB
  SB --> GHController["GitHubController"]
  SB --> GMController["GmailController<br/>(new)"]
  SB --> GmailService["GmailService.java<br/>(new)"]
  SB --> Models["EmailEvent & MeetingEvent Models"]
  SB --> Repos["MongoDB Repositories"]
  SB --> PY
  PY --> Insights["GitHub Insight &<br/>Gmail Insight (new)"]
  PY --> DB

