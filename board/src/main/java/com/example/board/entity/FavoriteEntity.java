package com.example.board.entity;

import com.example.board.entity.pk.FavoritePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="favorite")
@Table(name="favorite")
@IdClass(FavoritePk.class) // 참조하고 있는 pk가 다른 타입이므로 class로 묶음
public class FavoriteEntity {
    @Id
    private Integer boardNumber;
    @Id
    private String userEmail;
}
