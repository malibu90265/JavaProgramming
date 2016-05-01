package first.common.common;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
	스프링 사용 시, 컨트롤러(Controller)에 들어오는 파라미터(Parameter)를 수정하거나 공통적으로 추가를 해주어야 하는 경우가 있다. 
	예를 들어, 로그인을 한 사용자의 사용자 아이디나 닉네임등을 추가하는것을 생각해보자. 
	보통 그런 정보는 세션(Session)에 담아놓고 사용하는데, DB에 그러한 정보를 입력할 때에는 
	결국 세션에서 값을 꺼내와서 파라미터로 추가를 해야한다.
	그런 경우가 뭐 하나나 두번 정도 있다면 몰라도, 여러번 사용되는 값을 그렇게 일일히 세션에서 가져오는건 상당히 번거로운 일이다.
	HandlerMethodArgumentResolver 는 사용자 요청이 Controller에 도달하기 전에 그 요청의 파라미터들을 수정할 수 있도록 해준다.
	여기서 문제는 HandlerMethodArgumentResolver는 컨트롤러의 파라미터가 Map 형식이면 동작하지 않는다. 
	엄밀히 말을하면, 스프링 3.1에서 HandlerMethodArgumentResolver를 이용하여 그러한 기능을 만들더라도, 
	컨트롤러의 파라미터가 Map 형식이면 우리가 설정한 클래스가 아닌, 스프링에서 기본적으로 설정된 ArgumentResolver를 거치게 된다. 
	항상 그렇게 동작하는것은 아니고, 스프링의 <mvc:annotation-driven/>을 선언하게 되면 위에서 이야기한것처럼 동작하게 된다. (본인은 처음에 이것을 몰라서 진짜 몇날 몇일을 삽질했다.)
	따라서 <mvc:annotation-driven/>을 선언하려면 Map을 그대로 사용할 수 없고, 선언하지 않으면 문제는 없다. 
	그렇지만 앞으로 포스팅할 내용중에는 <mvc:annotation-driven/>을 선언해야 하는 경우가 있기때문에, 여기서는 Map을 대신할 CommandMap을 작성한다.
*/

public class CommandMap {
    Map<String,Object> map = new HashMap<String,Object>();
    /*
    절대로 Map을 상속받으면 안된다.
	Map을 상속받게 되면, 우리가 작성할 ArgumentResolver를 거치지 않게 되니 주의하자.
	여러가지 메서드들이 보이는데, 거의 대부분은 map의 기본기능을 다시 호출하는것에 지나지 않는다. 보통 가장 많이 사용하는 get, put 메서드만 있더도 큰 문제는 없겠지만, 여기서는 필자가 생각할때 필요한 맵의 기능들을 몇가지 골라서 추가했다. 
	그리고 다른곳에서는 이 CommandMap을 map과 똑같이 사용할 수 있도록 getMap 메서드를 추가했다. 
     */
    public Object get(String key){
        return map.get(key);
    }
     
    public void put(String key, Object value){
        map.put(key, value);
    }
     
    public Object remove(String key){
        return map.remove(key);
    }
     
    public boolean containsKey(String key){
        return map.containsKey(key);
    }
     
    public boolean containsValue(Object value){
        return map.containsValue(value);
    }
     
    public void clear(){
        map.clear();
    }
     
    public Set<Entry<String, Object>> entrySet(){
        return map.entrySet();
    }
     
    public Set<String> keySet(){
        return map.keySet();
    }
     
    public boolean isEmpty(){
        return map.isEmpty();
    }
     
    public void putAll(Map<? extends String, ?extends Object> m){
        map.putAll(m);
    }
     
    public Map<String,Object> getMap(){
        return map;
    }
}