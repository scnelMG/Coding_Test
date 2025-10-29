from datetime import datetime, timedelta

# UTC 현재 시간
utc_now = datetime.utcnow()

# 서울(KST) = UTC + 9시간
kst_now = utc_now + timedelta(hours=9)

# "YYYY-MM-DD" 형식으로 출력
print(kst_now.strftime("%Y-%m-%d"))
