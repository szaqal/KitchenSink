package servlet.mock.demo.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import servlet.mock.demo.TestedServlet;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class ServletMockTest {
	
	private final Mockery testContext = new Mockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	@Test
	public void testGet() throws IOException, ServletException {
		final HttpServletRequest requestMock = testContext.mock(HttpServletRequest.class);
		final HttpServletResponse responseMock = testContext.mock(HttpServletResponse.class);
		
		StringWriter stringWriter = new StringWriter();
		final PrintWriter writer = new PrintWriter(stringWriter);

		testContext.checking(new Expectations() {
			{
				oneOf(responseMock).getWriter();
				will(returnValue(writer));
			}

		});
		new TestedServlet().doGet(requestMock, responseMock);
		testContext.assertIsSatisfied();
		assertEquals("This is get", stringWriter.getBuffer().toString());
	}
	
	@Test
	public void testPost() throws IOException, ServletException {
		final HttpServletRequest requestMock = testContext.mock(HttpServletRequest.class);
		final HttpServletResponse responseMock = testContext.mock(HttpServletResponse.class);
		
		StringWriter stringWriter = new StringWriter();
		final PrintWriter writer = new PrintWriter(stringWriter);

		testContext.checking(new Expectations() {
			{
				oneOf(responseMock).getWriter();
				will(returnValue(writer));
			}

		});
		new TestedServlet().doPost(requestMock, responseMock);
		testContext.assertIsSatisfied();
		assertEquals("This is post", stringWriter.getBuffer().toString());
	}
}
