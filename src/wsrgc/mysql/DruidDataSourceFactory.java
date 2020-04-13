package wsrgc.mysql;

import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DruidDataSourceFactory implements DataSourceFactory {
	private DataSource dataSource;

	
	public DataSource getDataSource() {
		return this.dataSource;
	}

	
	public void setProperties(final Properties props) {
		try {
			this.dataSource = com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource(props);
		} catch (final RuntimeException e) {
			throw e;
		} catch (final Exception e) {
			throw new RuntimeException("init datasource error", e);
		}
	}
}