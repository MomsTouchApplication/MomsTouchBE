package com.momstouch.momstouchbe.domain.discountpolicy.dto;

import com.momstouch.momstouchbe.domain.discountpolicy.model.AmountDiscountPolicy;
import com.momstouch.momstouchbe.domain.discountpolicy.model.DiscountPolicy;
import com.momstouch.momstouchbe.domain.discountpolicy.model.RateDiscountPolicy;
import com.momstouch.momstouchbe.domain.discountpolicy.model.TimeDiscountPolicy;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountResponse {

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class DiscountListResponse {

        private List<AmountDiscountPolicyResponse> amountDiscountPolicyList;
        private List<RateDiscountPolicyResponse> rateDiscountPolicyList;
        private List<TimeDiscountPolicyResponse> timeDiscountPolicyList;

        public DiscountListResponse() {
            this.amountDiscountPolicyList = new ArrayList<>();
            this.rateDiscountPolicyList = new ArrayList<>();
            this.timeDiscountPolicyList = new ArrayList<>();
        }

        public static DiscountListResponse of(List<AmountDiscountPolicy> amountDiscountPolicyList,
                                              List<RateDiscountPolicy> rateDiscountPolicyList,
                                              List<TimeDiscountPolicy> timeDiscountPolicyList) {
            List<AmountDiscountPolicyResponse> amountDiscountPolicyResponseList = amountDiscountPolicyList.stream()
                    .map(AmountDiscountPolicyResponse::of)
                    .toList();

            List<RateDiscountPolicyResponse> rateDiscountPolicyResponses = rateDiscountPolicyList.stream()
                    .map(RateDiscountPolicyResponse::of).toList();

            List<TimeDiscountPolicyResponse> timeDiscountPolicyResponses = timeDiscountPolicyList.stream()
                    .map(TimeDiscountPolicyResponse::of)
                    .toList();

            return new DiscountListResponse(amountDiscountPolicyResponseList,rateDiscountPolicyResponses,timeDiscountPolicyResponses);
        }
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class AmountDiscountPolicyResponse {
        private Long id;
        private BigDecimal baseAmount;
        private BigDecimal discountAmount;

        public static AmountDiscountPolicyResponse of(AmountDiscountPolicy amountDiscountPolicy) {
            return new AmountDiscountPolicyResponse(amountDiscountPolicy.getId(),
                    amountDiscountPolicy.getBaseAmount().getAmount(),
                    amountDiscountPolicy.getDiscountAmount().getAmount());
        }
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class TimeDiscountPolicyResponse {
        private Long id;
        private LocalTime baseTime;
        private BigDecimal discountAmount;

        public static TimeDiscountPolicyResponse of(TimeDiscountPolicy discountPolicy) {
            return new TimeDiscountPolicyResponse(discountPolicy.getId(),
                    discountPolicy.getBaseTime(),
                    discountPolicy.getDiscountAmount().getAmount());
        }
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class RateDiscountPolicyResponse {
        private Long id;
        private BigDecimal baseAmount;
        private double discountRate;

        public static RateDiscountPolicyResponse of(RateDiscountPolicy discountPolicy) {
            return new RateDiscountPolicyResponse(discountPolicy.getId(),
                    discountPolicy.getBaseAmount().getAmount(),
                    discountPolicy.getDiscountRate());
        }
    }

}
