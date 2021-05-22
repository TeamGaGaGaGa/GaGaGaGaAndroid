# 서비스 이름 : 갸가갸가
> 서비스 한 줄 설명 : 솝트인들의 첫인상을 기록하고 기억할 수 있는 서비스

## 기능 및 개발 담당 부분
### 김희빈
- 메인뷰
  - bottom navigation과 viewpager2로 Fragment간 이동
- 리스트뷰
  - 사용자가 기록한 솝트인의 첫인상 리스트API 호출하여 보여줌
  - 리스트 아이템을 클릭하면 상세 정보로 변경된 뷰를 보여줌
 
### 이강민
- 등록뷰
  - 사용자가 질문에 대한 답을 작성하게 하고 데이터를 서버로 보냄
  - 사용자가 선택한 카테고리에 따라 질문이 바뀜

### 한유림
- 홈뷰
- 결과뷰
  - 등록뷰에서 완료가 되면 결과화면을 보여줌

## 서버코드 연결
### SoptServiceCreator
``` kotlin
object ServiceCreator {
    private const val BASE_URL = "http://54.180.159.90:5000/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)
}
```

### SoptService
``` kotlin
interface SoptService {
    @POST("friends")
    fun postAddFriend(
        @Body body: RequestFriendData
    ): Call<ResponseFriendData>
}
```
서버 연결을 위한 인터페이스 구현

### Callback
``` kotlin
            val requestFriendData = RequestFriendData(
                name = name,
                part = part,
                mbti = mbti,
                image = image,
                place = place,
                face = face,
                banmo = talkMode,
                answer1 = question1,
                answer2 = question2,
                ybob = soptYear,
                tmi = tmi

            )

            val call = ServiceCreator.soptService.postAddFriend(requestFriendData)
            call.enqueue(object : retrofit2.Callback<ResponseFriendData> {
                override fun onResponse(
                    call: Call<ResponseFriendData>,
                    response: Response<ResponseFriendData>
                ) {
                    if (response.body()?.success == true) {
                        Log.d("test", "성공")
                        Toast.makeText(requireContext(), response.body()?.message, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseFriendData>, t: Throwable) {
                    t.printStackTrace()
                    Log.d("test", "실패")
                }

            })
```
서버연결 성공 시 Toast메시지 
