# Servlet-Example
서블릿을 이용해 CRUD를 만든 예제 프로젝트


1) httpServlet을 상속받은 서블릿(컨트롤러)를 생성
2) doPost, doGet를 직접 생성해 post와 get처리
3) requsetDispatcher에 request 객체를 직접 수정하고 담아 포워딩 구현
4) 리다이렉트는 reponse 객체의 sendRedirect 사용
5) 디비 정보와 같은 민감한 정보는 프로퍼티 파일을 사용해 노출을 막음
