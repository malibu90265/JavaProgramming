package first.common.resolver;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import first.common.common.CommandMap;

//CustomMapArgumentResolver는 root context 영역에 등록이 되어야한다.(action-servlet.xml)
public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver {

	// supportsParameter 메서드 : Resolver가 적용 가능한지 검사하는 역할.
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// 컨트롤러의 파라미터가 CommandMap 클래스인지 검사
		return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	}

	// resolveArgument 메서드 : 파라미터와 기타 정보를 받아서 실제 객체를 반환
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();

		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();

		String key = null;
		String[] values = null;
		
		//request에 있는 값을 iterator를 이용하여 하나씩 가져오는 로직
		while (enumeration.hasMoreElements()) {
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null) {
				//request에 담겨있는 모든 key와 value를 commandMap에 저장
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		//모든 파라미터가 담겨있는 commandMap 반환
		return commandMap;
	}
}