package com.tm30.tango.entities;

import com.tm30.tango.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "wallet_transaction")
public class WalletTransaction extends BaseEntity {
    @OneToOne
    @JoinColumn(nullable = false,name = "card_id")
    private Card card;

    @OneToOne
    @JoinColumn(nullable = false,name = "wallet_id")
    private Wallet wallet;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal amount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
}
