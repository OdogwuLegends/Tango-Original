package com.tm30.tango.entities;

import com.tm30.tango.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "card_request")
public class CardRequest extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User requestedBy;

    private Long numberOfCards;

    private String colour;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    private String address;
}
