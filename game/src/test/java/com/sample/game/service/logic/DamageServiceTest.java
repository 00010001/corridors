package com.sample.game.service.logic;

import com.sample.base.model.enemy.EnemyClass;
import com.sample.base.model.factory.EnemyFactory;
import com.sample.base.model.factory.HeroFactory;
import com.sample.base.model.hero.HeroClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DamageServiceTest {

    DamageService damageService = new DamageService();

    @Test
    public void heroDamageShouldNotBeNull() {
        BigDecimal bigDecimal = damageService.calculateDamage(HeroFactory.getByClass(HeroClass.CAT),
                EnemyFactory.getByEnemyClass(EnemyClass.SKELETON));
        assertTrue(bigDecimal.compareTo(BigDecimal.ZERO) > 0);
        bigDecimal = damageService.calculateDamage(HeroFactory.getByClass(HeroClass.COW),
                EnemyFactory.getByEnemyClass(EnemyClass.SKELETON));
        assertTrue(bigDecimal.compareTo(BigDecimal.ZERO) > 0);
        bigDecimal = damageService.calculateDamage(HeroFactory.getByClass(HeroClass.DOG),
                EnemyFactory.getByEnemyClass(EnemyClass.SKELETON));
        assertTrue(bigDecimal.compareTo(BigDecimal.ZERO) > 0);
        bigDecimal = damageService.calculateDamage(HeroFactory.getByClass(HeroClass.OTHER_CAT),
                EnemyFactory.getByEnemyClass(EnemyClass.SKELETON));
        assertTrue(bigDecimal.compareTo(BigDecimal.ZERO) > 0);
        bigDecimal = damageService.calculateDamage(HeroFactory.getByClass(HeroClass.OWL),
                EnemyFactory.getByEnemyClass(EnemyClass.SKELETON));
        assertTrue(bigDecimal.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    public void EnemyDamageShouldNotBeNull() {
        BigDecimal bigDecimal = damageService.calculateDamage(EnemyFactory.getByEnemyClass(EnemyClass.SKELETON), HeroFactory.getByClass(HeroClass.CAT));
        assertTrue(bigDecimal.compareTo(BigDecimal.ZERO) > 0);
    }
}