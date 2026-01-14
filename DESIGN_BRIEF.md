# EXAONE Agent 디자인 요청 가이드

## 📋 프로젝트 개요

**프로젝트명**: EXAONE AI Agent  
**플랫폼**: Android (Material Design 3 기반)  
**목적**: 엔터프라이즈용 AI 에이전트 애플리케이션  
**디자인 도구**: Figma

---

## 🎨 현재 디자인 시스템

### 색상 팔레트

#### Primary Colors
- **EXAONE Red**: `#E31E2C` (메인 브랜드 컬러)
- **EXAONE Red Dark**: `#C01828` (호버/활성 상태)

#### Background Colors
- **White**: `#FFFFFF` (기본 배경)
- **Light Gray**: `#F8F9FA` (입력 필드 배경)

#### Text Colors
- **Primary Text**: `#212529` (주요 텍스트)
- **Secondary Text**: `#6C757D` (부가 설명 텍스트)
- **Hint Text**: `#ADB5BD` (플레이스홀더)

#### Card Colors
- **Card Background**: `#FFFFFF`
- **Card Border**: `#E9ECEF`

#### Icon Colors
- **Purple**: `#9C27B0` (배경: `#F3E5F5`)
- **Orange**: `#FF9800` (배경: `#FFF3E0`)
- **Blue**: `#2196F3` (배경: `#E3F2FD`)

### 타이포그래피

- **Hero Title**: 32sp, Bold
- **Card Title**: 18sp, Bold
- **Card Description**: 14sp, Regular
- **Body Text**: 16sp, Regular
- **Label**: 14sp, Bold
- **Caption**: 12sp, Regular

### 간격 시스템 (Spacing)

- **Small**: 8dp
- **Medium**: 16dp
- **Large**: 24dp
- **XLarge**: 32dp
- **XXLarge**: 40dp, 48dp

### Border Radius

- **Small**: 8dp (입력 필드)
- **Medium**: 12dp (카드)
- **Large**: 24dp (버튼, 입력 필드)

---

## 📱 화면 구조

### 1. 로그인 화면 (LoginActivity)

#### 주요 컴포넌트
- **로고**: 상단 중앙 배치 (80dp × 80dp)
- **브랜드 텍스트**: "● EXAONE 관찰"
- **제목**: "로그인" (32sp, Bold)
- **서브타이틀**: 설명 텍스트
- **이메일 입력 필드**: 아이콘 + 텍스트 입력
- **비밀번호 입력 필드**: 아이콘 + 텍스트 입력 + 토글 버튼
- **로그인 버튼**: 전체 너비, 56dp 높이
- **회원가입 링크**: 하단 중앙
- **저작권 정보**: 최하단

#### 디자인 요청사항
- [ ] 로고 디자인 (현재는 기본 아이콘 사용)
- [ ] 입력 필드 포커스 상태 디자인
- [ ] 에러 상태 디자인 (유효성 검사 실패 시)
- [ ] 로딩 상태 디자인 (로그인 진행 중)
- [ ] 다크 모드 대응 (선택사항)

---

### 2. 메인 화면 (MainActivity)

#### 주요 컴포넌트

**상단 영역**
- **Toolbar**: 앱 제목 "EXAONE AI Agent"

**콘텐츠 영역**
- **Hero Section**: 
  - "업무의 모든 순간을"
  - "AI와 함께하세요"
  
- **기능 카드 3개**:
  1. **NL-to-SQL 조회**
     - 아이콘: 보라색 배경
     - 제목: "NL-to-SQL 조회"
     - 설명: "자연어 질문만으로 데이터 조회"
  
  2. **자동 리포팅 & 요약**
     - 아이콘: 주황색 배경
     - 제목: "자동 리포팅 & 요약"
     - 설명: "데이터를 자동으로 분석하고 리포트 생성"
  
  3. **Voice Interface**
     - 아이콘: 파란색 배경
     - 제목: "Voice Interface"
     - 설명: "음성으로 손쉽게 업무 처리"

- **하단 정보**: 
  - "엔터프라이즈급 보안"
  - "실시간 응답 보장"

**입력 영역 (하단 고정)**
- **구분선**: 상단 1dp
- **입력 필드**: 둥근 모서리 (24dp), 플레이스홀더 포함
- **음성 버튼**: 원형, 테두리 스타일
- **전송 버튼**: 원형, EXAONE Red 배경

#### 디자인 요청사항
- [ ] 각 기능 카드의 아이콘 디자인 (현재는 시스템 아이콘 사용)
- [ ] 카드 호버/터치 피드백 상태
- [ ] 입력 필드 포커스 상태
- [ ] 메시지 리스트 디자인 (추후 구현 예정)
- [ ] 로딩 인디케이터 디자인
- [ ] 빈 상태(Empty State) 디자인

---

## 🎯 디자인 개선 요청사항

### 우선순위 높음 (High Priority)

1. **아이콘 디자인**
   - NL-to-SQL, 리포팅, 음성 인터페이스 각각의 커스텀 아이콘
   - 일관된 스타일 가이드
   - SVG 또는 벡터 형식 권장

2. **로고 디자인**
   - EXAONE 브랜드 아이덴티티 반영
   - 다양한 크기 버전 (mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi)

3. **컴포넌트 상태 디자인**
   - Normal, Focused, Disabled, Error 상태
   - 터치 피드백 (Ripple Effect)

4. **로딩 상태**
   - Progress Bar 스타일
   - Skeleton Screen (선택사항)

### 우선순위 중간 (Medium Priority)

5. **애니메이션 가이드**
   - 화면 전환 애니메이션
   - 컴포넌트 인터랙션 애니메이션

6. **에러/빈 상태 디자인**
   - 에러 메시지 표시 방식
   - 빈 리스트 상태

7. **다크 모드**
   - 다크 테마 색상 팔레트
   - 컴포넌트별 다크 모드 스타일

### 우선순위 낮음 (Low Priority)

8. **온보딩 화면**
   - 첫 실행 시 앱 소개 화면

9. **설정 화면**
   - 사용자 설정 UI

---

## 📐 Figma 작업 가이드

### 1. 파일 구조 제안

```
EXAONE Agent Design
├── 🎨 Design System
│   ├── Colors
│   ├── Typography
│   ├── Spacing
│   ├── Components
│   │   ├── Buttons
│   │   ├── Input Fields
│   │   ├── Cards
│   │   └── Icons
│   └── States (Normal, Focused, Disabled, Error)
├── 📱 Screens
│   ├── Login
│   ├── Main
│   └── [Future Screens]
└── 📋 Assets
    ├── Icons
    └── Logos
```

### 2. 작업 시 주의사항

#### Android 개발을 위한 필수 사항
- [ ] **dp 단위 사용**: px 대신 dp 단위로 작업 (1dp = 1px @ mdpi 기준)
- [ ] **8dp 그리드 시스템**: 간격은 8dp의 배수로 설정
- [ ] **Material Design 3 가이드라인 준수**
- [ ] **Safe Area 고려**: 노치, 상태바 영역 고려
- [ ] **다양한 화면 크기**: 360dp ~ 840dp 너비 대응

#### Figma 설정 권장사항
- **Frame 크기**: 360 × 800 (기본), 375 × 812 (iPhone X 기준)
- **Grid**: 8px 그리드 활성화
- **Auto Layout**: 컴포넌트에 Auto Layout 적용
- **Components**: 재사용 가능한 컴포넌트로 제작
- **Variants**: 상태별 Variant 생성 (Normal, Focused, Disabled, Error)

### 3. 개발자 전달 시 포함할 내용

#### 필수 전달 항목
1. **Figma 파일 링크** (공유 권한 설정)
2. **디자인 시스템 문서** (색상, 타이포그래피, 간격)
3. **아이콘 파일** (SVG 또는 PNG @1x, @2x, @3x)
4. **로고 파일** (다양한 해상도)
5. **컴포넌트 스펙** (크기, 간격, 색상 코드)

#### 권장 전달 항목
6. **프로토타입 링크** (인터랙션 데모)
7. **디자인 토큰** (Figma Tokens 플러그인 사용 시)
8. **스타일 가이드 PDF** (참고용)

---

## 💬 디자이너에게 전달할 메시지 예시

```
안녕하세요! EXAONE AI Agent 앱의 디자인을 부탁드립니다.

현재 기본적인 레이아웃과 색상 시스템은 구축되어 있지만, 
다음 항목들에 대한 디자인이 필요합니다:

1. 커스텀 아이콘 디자인 (NL-to-SQL, 리포팅, 음성 인터페이스)
2. EXAONE 로고 디자인
3. 컴포넌트 상태별 디자인 (포커스, 에러, 로딩 등)
4. 전체적인 UI/UX 개선

Figma로 작업해주시면 되며, 위의 가이드 문서를 참고해주세요.
특히 Android 개발을 위해 dp 단위와 8dp 그리드 시스템을 
준수해주시면 개발 작업이 수월할 것 같습니다.

작업 완료 후 Figma 파일 공유와 함께 아이콘/로고 파일도 
별도로 전달해주시면 감사하겠습니다!
```

---

## 📝 체크리스트

### 디자이너 작업 전
- [ ] 프로젝트 목적 및 타겟 사용자 공유
- [ ] 현재 디자인 시스템 문서 전달
- [ ] 화면별 요구사항 명확히 전달

### 디자이너 작업 중
- [ ] 중간 리뷰 및 피드백
- [ ] 개발 가능성 검토 (기술적 제약사항 확인)

### 디자이너 작업 완료 후
- [ ] Figma 파일 리뷰
- [ ] 개발자와 디자인 핸드오프 미팅
- [ ] 아이콘/로고 파일 수령
- [ ] 디자인 시스템 문서 최종 확인

---

## 🔗 참고 자료

- [Material Design 3 가이드라인](https://m3.material.io/)
- [Android 디자인 가이드](https://developer.android.com/design)
- [Figma Android 디자인 템플릿](https://www.figma.com/community)

---

**작성일**: 2025년  
**버전**: 1.0
