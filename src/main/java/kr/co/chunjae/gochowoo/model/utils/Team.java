package kr.co.chunjae.gochowoo.model.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Team {

    Mystic("Mystic"),
    Instinct("Instinct"),
    Valor("Valor");

    final String teamName;

    public static Team getTeam(String teamName) {
        return Team.valueOf(teamName);
    }

}
