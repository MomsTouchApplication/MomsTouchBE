package com.momstouch.momstouchbe.domain.discountpolicy.model;

import com.momstouch.momstouchbe.global.vo.Money;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@DiscriminatorValue("AMOUNT_DISCOUNT_POLICY")
//@Builder
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AmountDiscountPolicy extends DiscountPolicy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "base_amount"))
    })
    private Money baseAmount;

    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "discount_amount"))
    })
    private Money discountAmount;

    @Builder
    public AmountDiscountPolicy(int baseAmount, int discountAmount) {
        if(discountAmount > baseAmount) {
            throw new IllegalArgumentException();
        }
        this.baseAmount = Money.of(baseAmount);
        this.discountAmount = Money.of(discountAmount);
    }

    @Override
    public Money discount(Money price) {
        if (price.equalsOrMore(baseAmount)) {
            return price.minus(discountAmount);
        }
        return price;
    }
}
