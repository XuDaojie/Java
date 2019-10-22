package io.github.xudaojie.boot.bean;

import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author xdj
 * @date 2018/9/14
 */
public class BeanCopierTest {

    @Test
    public void beanCopierTest() {
        BeanCopier copier = BeanCopier.create(AccountEntity.class, AccountDTO.class, false);
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1);
        accountEntity.setCreateTime(new Timestamp(10043143243L));
        accountEntity.setBalance(BigDecimal.valueOf(4000L));

        AccountDTO accountDTO = new AccountDTO();
        copier.copy(accountEntity, accountDTO, null);
    }
}
