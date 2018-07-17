package com.ddc.template.datasources;

import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Description: 数据源自动切换拦截器
 * @author harry.zhang
 * @CreateDate:	2018年3月28日
 * @version 1.0
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }) })
public class DynamicDataSourceInterceptor implements Interceptor {

	//\\u0020代表空格
	private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();
		Object[] objects = invocation.getArgs();
		MappedStatement ms = (MappedStatement) objects[0];
		String lookupkey = DataSourceNames.FIRST;
		if (synchronizationActive != true) {
			// 读方法
			if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
				// selectKey为自增id查询主键(SELECT LAST_INSERT_ID())方法，使用主库
				if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
					lookupkey = DataSourceNames.FIRST;
				} else {
					BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
					String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
					if (sql.matches(REGEX)) {
						lookupkey = DataSourceNames.FIRST;
					} else {
						lookupkey = DataSourceNames.SECOND;
					}
				}
			} else {
				lookupkey = DataSourceNames.FIRST;
			}
			DynamicDataSource.setDataSource(lookupkey);
		}else{
			DynamicDataSource.setDataSource(lookupkey);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties arg0) {

	}

}
