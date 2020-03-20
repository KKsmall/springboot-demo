package com.learn.flyway.migration;

import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java 迁移脚本，可以通过类名按照和 「2.4 SQL-based migrations」 一样的命名约定，自动获得版本号
 * 。当然，也可以通过重写 #getVersion() 方法，自定义版本号
 * @author liujin
 * @datetime 2020/3/13 9:14
 */
public class V1_1__FixUsername extends BaseJavaMigration {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void migrate(Context context) throws Exception {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(context.getConfiguration().getDataSource());
        jdbcTemplate.query("SELECT id, username, password, create_time FROM users", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                do {
                    String username = resultSet.getString("username");
                    if ("yudaoyuanma".equals(username)) {
                        Integer id = resultSet.getInt("id");
                        jdbcTemplate.update("UPDATE users SET username = ? where id = ?",
                                "yutou", id);
                        logger.info("[migrate][更新 user({}) 的用户名({} => {})", id, username, "yutou");
                    }
                } while (resultSet.next());
            }
        });
    }

    @Override
    public Integer getChecksum() {
        return 11; // 默认返回，是 null 。
    }

    @Override
    public boolean canExecuteInTransaction() {
        return true; // 默认返回，也是 true
    }

    @Override
    public MigrationVersion getVersion() {
        return super.getVersion(); // 默认按照约定的规则，从类名中解析获得。可以自定义
    }
}
