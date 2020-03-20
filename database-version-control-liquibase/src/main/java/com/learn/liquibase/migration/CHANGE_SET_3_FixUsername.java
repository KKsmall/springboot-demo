package com.learn.liquibase.migration;

import com.mysql.cj.jdbc.JdbcConnection;
import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.exception.CustomChangeException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  Java-based migrations 基于java代码做数据库管理
 * @author liujin
 * @datetime 2020/3/13 10:49
 */
public class CHANGE_SET_3_FixUsername implements CustomTaskChange {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Database database) throws CustomChangeException {
        JdbcConnection jdbcConnection = (JdbcConnection)database.getConnection();
        try (PreparedStatement preparedStatement = jdbcConnection.prepareStatement("SELECT id, username, password create_time FROM users")){
            try (ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    if ("yudaoyuanma".equals(username)) {
                        Integer id = resultSet.getInt("id");
                        // 这里，再来一刀更新操作，偷懒不写了。
                        logger.info("[migrate][更新 user({}) 的用户名({} => {})", id, username, "yutou");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getConfirmationMessage() {
        return null;
    }

    @Override
    public void setUp() throws SetupException {

    }

    @Override
    public void setFileOpener(ResourceAccessor resourceAccessor) {

    }

    @Override
    public ValidationErrors validate(Database database) {
        return null;
    }
}
