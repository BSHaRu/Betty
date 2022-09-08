package com.koreate.betty.domain.book.crawler;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.koreate.betty.domain.book.service.BookService;
import com.koreate.betty.domain.book.vo.Book;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, RootConfig.class, AppConfig.class })
@WebAppConfiguration
public class CrawlerTest {
	
	@Autowired
	BookService bs;
	
	@Autowired
	ServletContext context;
	
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe"; // 드라이버 경로

	@Test
	public void 크롤러_테스트() throws Exception {
		// 드라이버 설정
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
			System.out.println("드라이버 등록");
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
		WebDriver driver = null;
		Selenium c = new Selenium();
		try {

			for (int i = 1; i <= 6; i++) { // 25 X 40 = 1000개 게시물 검색 (ViewRowsCount X 포문 반복횟수)

				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);

				int cid = 1196;
				// 2105 : 고전 O 완료
				// 170 : 경제 O 완료
				// 517 : 예술/대중문화 O 완료
				// 74 : 역사 O 완료
				// 987 : 과학 O 완료
				// 656 : 인문학 O 완료
				// 1237 : 종교 O 완료
				// 1196 : 여행 O 완료
				
				// webapp/crawlingimg
				// webapp/resources/img/book/origin
				String imgFolderPath = context.getRealPath(File.separator + "resources" + File.separator + "img" + File.separator + "book" + File.separator + "origin");
				System.out.println("imgPath : " + imgFolderPath);
				List<Book> bookList = c.crawling(driver,
						"https://www.aladin.co.kr/shop/wbrowse.aspx?BrowseTarget=List&ViewRowsCount=25&ViewType=Detail&PublishMonth=0&SortOrder=2&page="
								+ i + "&Stockstatus=1&PublishDay=84&CID=" + cid, imgFolderPath);

				for (Book book : bookList) {
					bs.insertByCrawler(book);
				}
				if (driver != null) {
					driver.close();
					driver.quit();
					driver = null;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (driver != null) {
				driver.close();
				driver.quit();				
			}
		}
	}

}
