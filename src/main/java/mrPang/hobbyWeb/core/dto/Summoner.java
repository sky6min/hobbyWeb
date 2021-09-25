package mrPang.hobbyWeb.core.dto;

import lombok.Data;

@Data
public class Summoner {
    String accountId;
    int profileIconId;
    long revisionDate;
    String name;
    String id;
    String puuid;
    long summonerLevel;

    public Summoner() {

    }

    public Summoner(String accountId, int profileIconId, long revisionDate, String name, String id, String puuid, long summonerLevel) {
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.id = id;
        this.puuid = puuid;
        this.summonerLevel = summonerLevel;
    }

    @Override
    public String toString() {
        return "Summoner{" +
                "accountId='" + accountId + '\'' +
                ", profileIconId=" + profileIconId +
                ", revisionDate=" + revisionDate +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", puuid='" + puuid + '\'' +
                ", summonerLevel=" + summonerLevel +
                '}';
    }
}

