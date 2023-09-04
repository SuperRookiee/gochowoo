package kr.co.chunjae.gochowoo.model.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Type {
    BUG("벌레", "bug"),
    DARK("악", "dark"),
    DRAGON("드래곤", "dragon"),
    ELECTRIC("전기", "electric"),
    FIRE("불", "fire"),
    FAIRY("페어리", "fairy"),
    FIGHTING("격투", "fighting"),
    FLYING("비행", "flying"),
    GHOST("고스트", "ghost"),
    GRASS("풀", "grass"),
    GROUND("땅", "ground"),
    ICE("얼음", "ice"),
    NORMAL("노말", "normal"),
    POISON("독", "poison"),
    PSYCHIC("에스퍼", "psychic"),
    ROCK("바위", "rock"),
    STEEL("강철", "steel"),
    WATER("물", "water");

    final String ko;
    final String eng;

    public static List<String> getAllTypes() {
        return Arrays.stream(Type.values())
                .map(Type::name)
                .collect(Collectors.toList());
    }
}
