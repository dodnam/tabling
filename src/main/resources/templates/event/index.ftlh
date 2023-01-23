<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html lang="kr" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<p>
  <span" th:text="'이벤트 테스트 조회'">This is events page</span>
</p>
<table>
  <thead>
    <tr>
      <th>장소 ID</th>
      <th>이벤트명</th>
      <th>이벤트 상태</th>
      <th>시작 일시</th>
      <th>종료 일시</th>
      <th>현재 인원</th>
      <th>최대 수용 인원</th>
      <th>상세</th>
    </tr>
  </thead>
  <tbody>
    <#list events as event>
        <tr>
          <td>${event.placeId()!"-"}</td>
          <td>${event.eventName()!"-"}</td>
          <td>${event.eventStatus()!"-"}</td>
          <td>${event.eventStartDatetime()!"-"}</td>
          <td>${event.eventEndDatetime()!"-"}</td>
          <td>${event.currentNumberOfPeople()!"-"}</td>
          <td>${event.capacity()!"-"}</td>
          <td><a href="/events/${event.id()}">상세</a></td>
        </tr>
  </tbody>
</table>

</body>
</html>