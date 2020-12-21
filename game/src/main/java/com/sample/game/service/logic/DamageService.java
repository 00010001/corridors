package com.sample.game.service.logic;

import com.sample.base.model.Unit;
import com.sample.game.AppParameters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class DamageService {

    public BigDecimal calculateDamage(Unit first, Unit second) {
        BigDecimal result;
        result = BigDecimal.valueOf(2)
                .multiply(BigDecimal.valueOf(first.getLevel()))
                .setScale(3, RoundingMode.CEILING);
        result = result.add(BigDecimal.TEN);
        result = result.divide(BigDecimal.valueOf(250), RoundingMode.CEILING)
                .setScale(3, RoundingMode.CEILING);
        BigDecimal attackDefence = BigDecimal.valueOf(first.getAttack())
                .divide(BigDecimal.valueOf(second.getDefence()), RoundingMode.CEILING)
                .setScale(3, RoundingMode.CEILING);
        int baseDamage = ThreadLocalRandom.current()
                .nextInt(AppParameters.BASE_DAMAGE - 10, AppParameters.BASE_DAMAGE + 10);
        return result.multiply(attackDefence).multiply(BigDecimal.valueOf(baseDamage))
                .setScale(1, RoundingMode.HALF_UP);
    }
}
