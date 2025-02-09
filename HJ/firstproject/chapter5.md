# 5장 게시글 읽기 Read

## 게시글 읽는 과정
1. 클라이언트로부터 Id값 같은 파라미터를 얻는다.
2. 해당 Id값을 이용하여 레파지토리를 통해 엔티티를 얻는다.
3. 엔티티로 모델에 값들을 입혀 뷰로 나타낸다.
    - 뷰로 나타낼 때는 모델의 이름을 mustache에 넣어서 값들 넣을 수 있다.

## 1. url요청 받기
```java
@GetMapping("/articles/{id}")
public String show(@PathVariable Long id, Model model) {
log.info("id : " + id);
//        1. id를 조회해 데이터 가져오기
//        2. 모델에 데이터 등록하기
//        3. 뷰 페이지 반환하기

//        Optional<Article> article = articleRepository.findById(id);
Article articleEntity = articleRepository.findById(id).orElse(null);

      model.addAttribute("article", articleEntity);

      return "articles/show";
}
```

> 매개변수에 @PathVariable annoatation을 이용하여 클라이언트가 요청한 id 파라미터 값을 얻을 수 있음

2. id를 이용하여 레파지토리를 통해 엔티티를 얻는다.
```java
Article articleEntity = articleRepository.findById(id).orElse(null);
```

> findById 메서드가 반환하는 값이 null일 수 있으므로 `orElse(null)`을 넣어 준다.

3. 엔티티로 모델에 값들을 입혀 뷰로 나타낸다.
```java
model.addAttribute("article", articleEntity);
```

> article을 통해 mustache에서 뷰를 작성함

4. 뷰 작성

```html
{{>layouts/header}}
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Title</th>
        <th scope="col">Content</th>
    </tr>
    </thead>
    <tbody>
        {{#article}}
        <tr>
            <th scope="row">{{id}}</th>
            <td colspan="2">{{title}}</td>
            <td>{{content}}</td>
        </tr>
        {{/article}}
    </tbody>
</table>
{{>layouts/footer}}
```

## 모든 데이터 가져오기
1. 레파지토리를 통해 모든 데이터를 엔티티로 변환함
2. 엔티티를 모델로 변환함
3. 뷰를 작성함

```java
@GetMapping("/articles")
   public String index(Model model) {
//      1. 모든 데이터 가져오기
//      2. 모델에 데이터 등록하기
//      3. 뷰 페이지 설정하기

      /// 다운 캐스팅을 통해 iterable객체를 List로 변환
//      List<Article> articleEntityList = (List<Article>)articleRepository.findAll();
//      Iterable<Article> articles = articleRepository.findAll();

      /// ArticleRepository에서 findAll메서드 overriding
      ArrayList<Article> articleEntityList = articleRepository.findAll();
      model.addAttribute("articleList", articleEntityList);

      return "articles/index";
```

> findAll() 메서드는 iterable객체를 반환하므로 형변환이 필요하다. 위 코드에서는 ArticleRepository에서 findAll 메서드를 overrideg하는 방식으로 해결하였다.

### mustache 작성
```html
{{>layouts/header}}
{{>layouts/header}}
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Title</th>
        <th scope="col">Content</th>
    </tr>
    </thead>
    <tbody>
    {{#articleList}}
        <tr>
            <th scope="row">{{id}}</th>
            <td colspan="2">{{title}}</td>
            <td>{{content}}</td>
        </tr>
    {{/articleList}}
    </tbody>
</table>
{{>layouts/footer}}
{{>layouts/footer}}
```

> 만약 ArrayList로 모델이 전달된 경우 해당 부분을 원소 수 만큼 반복한다.