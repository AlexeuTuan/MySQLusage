package alekseytyan.springmysql;


import alekseytyan.config.EmbeddedJdbcConfig;
import alekseytyan.config.PopulatorJdbcConfig;
import alekseytyan.dao.SingerDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Created by iuliana.cosmina on 4/15/17.
 */
public class JdbcCfgTest {

	@Test
	public void testH2DB() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/embedded-h2-cfg.xml");
		ctx.refresh();
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	@Test
	public void testDerby() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/embedded-derby-cfg.xml");
		ctx.refresh();
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	@Test
	public void testEmbeddedJavaConfig() {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	@Test
	public void testPopulatorJavaConfig() {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(PopulatorJdbcConfig.class);
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	private void testDao(SingerDao singerDao) {
		assertNotNull(singerDao);
		String singerName = singerDao.findNameById(1l);
		assertTrue("John Mayer".equals(singerName));

	}
}
