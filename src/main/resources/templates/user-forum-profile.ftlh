<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SRHL-FORUM</title>

    <link rel="stylesheet" href="/CSS/forum.css">
    <link href="https://fonts.googleapis.com/css2?family=Sofia+Sans+Condensed:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=PT+Sans+Narrow:wght@700&display=swap" rel="stylesheet">
    <link rel="apple-touch-icon" sizes="180x180" href="/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/favicon/favicon-16x16.png">
    <link rel="manifest" href="/favicon/site.webmanifest">
    <link rel="mask-icon" href="/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#2b5797">
    <meta name="theme-color" content="#ffffff">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>

<div class="container">

    <div class="header">
        <div class="header-container">

            <div class="logo-main">
                <div class="SRHL"><a href="/">
                        <svg width="21" height="43" viewBox="0 0 21 43" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M8.31777 1.25868C7.76409 1.48271 7.21041 1.75843 7.08929 1.86182C6.77785 2.12031 6.84706 2.65452 7.60837 6.48016C7.93712 8.10003 8.19666 9.53034 8.19666 9.6682C8.17935 10.2196 7.86791 9.22015 7.34883 6.96268C7.03738 5.63577 6.74324 4.39502 6.67403 4.20546C6.51831 3.70571 6.37989 4.98093 6.12035 9.30631L5.89542 13.0286L4.78805 13.5972C3.30003 14.3555 1.46596 16.1477 0.843069 17.4573C0.116361 18.9393 0.0644536 20.1801 0.652741 21.4553L1.11991 22.4548L0.687346 22.0584L0.272084 21.6621L0.150966 23.3509C0.0817562 24.2642 0.0471511 27.2627 0.0990587 29.9854C0.168269 33.8628 0.237479 35.0001 0.410505 35.2414C0.912279 35.8273 8.73304 42.9271 8.81955 42.8582C8.85415 42.8065 8.43889 39.9976 7.86791 36.5855L6.84706 30.399L6.27607 29.9682C5.96463 29.727 4.96108 28.9515 4.04404 28.2277L2.383 26.918L2.03695 25.6428C1.82931 24.9363 1.7428 24.3504 1.81201 24.3159C1.88122 24.2815 2.55602 24.5572 3.30003 24.9363C4.04404 25.2982 5.42825 25.9013 6.37989 26.2632C7.33153 26.6423 8.19666 27.0042 8.30047 27.0731C8.40429 27.1421 8.62922 27.8486 8.80225 28.6241C9.07909 29.9337 9.09639 30.5714 8.83685 32.6048C8.81955 32.7944 9.07909 33.1562 9.51165 33.5181L10.2211 34.104L10.8959 33.5526L11.5707 33.0012L11.588 30.7609C11.588 29.3306 11.6918 28.2277 11.8475 27.7624C12.0897 27.0214 12.1243 26.987 13.3182 26.6079C14.0103 26.4011 15.481 25.7807 16.5884 25.2465C17.7131 24.7123 18.6647 24.2987 18.682 24.3331C18.7166 24.3676 18.6474 24.7812 18.509 25.2465C18.3706 25.7118 18.2148 26.2977 18.1629 26.5389C18.0937 26.8319 17.3843 27.5212 15.8098 28.7447C14.5813 29.7097 13.5604 30.5197 13.5604 30.5369C13.5604 30.5541 13.0933 33.3286 12.5223 36.6889C11.9686 40.0493 11.536 42.8237 11.5707 42.8754C11.6226 42.9099 12.4012 42.2551 13.3355 41.4107C18.4571 36.7579 20.0662 35.2069 20.2046 34.8106C20.3777 34.2591 20.4469 22.1274 20.2738 21.9378C20.2046 21.8689 20.0316 21.9206 19.8759 22.0412C19.5471 22.3169 19.5471 22.0929 19.8759 21.5242C20.3431 20.7143 20.1008 18.7326 19.3222 17.0955C18.8204 16.0098 17.3151 14.5795 15.6887 13.6489L14.5121 12.9769L14.4775 11.2708C14.4256 8.99612 14.0968 4.7052 13.9411 4.27439C13.8546 4.05037 13.5951 4.8603 13.1452 6.82482C12.7645 8.41022 12.4012 9.84052 12.3147 9.97838C12.0897 10.3403 12.2628 9.35801 12.8856 6.46293C13.1798 5.13602 13.4566 3.58508 13.5085 2.99918L13.6124 1.94799L12.505 1.44824C10.9824 0.758936 9.65007 0.690006 8.31777 1.25868ZM11.4149 11.2881C11.7437 11.4432 12.0032 11.6327 12.0032 11.7189C12.0032 11.805 11.7783 11.7706 11.4841 11.6155C11.2073 11.4776 10.619 11.357 10.1865 11.357C9.75389 11.357 9.1656 11.4776 8.88876 11.6155C8.59461 11.7706 8.36968 11.805 8.36968 11.7361C8.36968 11.4604 9.47705 11.0123 10.1518 11.0123C10.5325 11.0123 11.0862 11.133 11.4149 11.2881ZM8.02363 12.8735C8.02363 12.9424 7.60837 13.1492 7.1239 13.3215C5.7916 13.7696 4.18246 14.7001 2.98859 15.6996C1.69089 16.768 1.93313 16.2338 3.28273 14.9931C4.37279 13.9936 5.51476 13.356 6.86436 12.9941C7.95442 12.7011 8.02363 12.7011 8.02363 12.8735ZM13.4739 12.9941C14.0276 13.1492 14.91 13.5111 15.4291 13.804C16.3635 14.3382 18.5782 16.2683 18.5782 16.544C18.5782 16.6302 18.0937 16.3028 17.5054 15.8202C16.277 14.8552 14.7889 13.9763 13.3874 13.4077C11.7264 12.7356 11.761 12.5633 13.4739 12.9941Z"
                                  fill="white"/>
                        </svg>

                    </a></div>
            </div>

            <div class="nav-forum">
                <div class="inl"><a href="/">ГЛАВНАЯ</a></div>
                <div class="inl"><a href="/forum">ФОРУМЫ</a></div>

            </div>

            <div class="profile">
                <#if user.username??>
                    <div class="inl"><a href="/forum/profile">${user.username}</a></div>
                <#else>
                    <div class="inl"><a href="/login">Войти</a></div>
                </#if>
            </div>

        </div>

    </div>


    <div class="body-info-forum">
        <div class="body-info-container">
            <div class="body-content">

                <div class="body-content-box">

                    <div class="rdel-apl">
                        <div class="rdel-apl-text">
                            <div class="inline-block">${user.username}</div>

                            <div class="inline-block float-right">
                                <form action="/logout" method="post" class="reltext">
                                    <button class="bc-none" type="submit">Выйти</button>
                                </form>
                            </div>

                        </div>


                    </div>

                    <div class="rdel-apl-content">
                        <div class="link-rdel-content">Ваши созданные темы</div>
                    </div>

                    <#list allSubjects as subjectSelectForForumInfo>
                        <#if subjectSelectForForumInfo.user.id == user.id>

                            <div class="rdel-apl-content">


                                <div class="link-rdel-content">


                                    <div class="descrip-link-rdel"><a
                                                href="/forum/subject/${subjectSelectForForumInfo.id}">${subjectSelectForForumInfo.zagolovok}</a>
                                    </div>

                                    <div class="information-descrip">
                                        <div class="info-tem-count">
                                            <div class="content-centre">${subjectSelectForForumInfo.messages_count}</div>
                                            <div class="content-centre">Сообщений</div>

                                        </div>

                                        <div class="author-descrip">
                                            <div class="content-centre">
                                                ${subjectSelectForForumInfo.user.username}</div>
                                            <div class="content-centre">Создатель поста</div>

                                        </div>

                                        <div class="author-descrip">


                                            <form action="/forum/delete/${subjectSelectForForumInfo.id}"
                                                  method="post">
                                                <button type="submit" class="submit-delete">
                                                    <svg xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
                                                         viewBox="0 0 64 64" width="25px" height="25px">
                                                        <path d="M 28 11 C 26.895 11 26 11.895 26 13 L 26 14 L 13 14 C 11.896 14 11 14.896 11 16 C 11 17.104 11.896 18 13 18 L 14.160156 18 L 16.701172 48.498047 C 16.957172 51.583047 19.585641 54 22.681641 54 L 41.318359 54 C 44.414359 54 47.041828 51.583047 47.298828 48.498047 L 49.839844 18 L 51 18 C 52.104 18 53 17.104 53 16 C 53 14.896 52.104 14 51 14 L 38 14 L 38 13 C 38 11.895 37.105 11 36 11 L 28 11 z M 18.173828 18 L 45.828125 18 L 43.3125 48.166016 C 43.2265 49.194016 42.352313 50 41.320312 50 L 22.681641 50 C 21.648641 50 20.7725 49.194016 20.6875 48.166016 L 18.173828 18 z"/>
                                                    </svg>
                                                </button>
                                            </form>


                                        </div>
                                    </div>
                                </div>

                                <#if (subjectSelectForForumInfo?has_next)>
                                    <div class="strin-white"></div>
                                <#else>

                                </#if>

                            </div>

                        </#if>
                    </#list>


                </div>
            </div>
        </div>
    </div>


</div>

<div class="footer">
    <div class="footer-container">

        <div class="inl"><a href="/">SRHL</a></div>
        <div class="inl"><a href="/forum/rules">Условия и правила</a></div>


    </div>
</div>



</body>
</html>