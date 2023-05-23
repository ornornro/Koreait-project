class UtilService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new UtilService();
        }
        return this.#instance;
    }

    loadUtil() {
        const util = document.querySelector(".util");
        const principal = PrincipalApi.getInstance().getPrincipal();

        util.innerHTML = `
            <div class="util-wrap">
                <ul class="util-ul">
                    <li>
                        <ul>
                            <li>부산도서관</li>
                            <li>전자도서관</li>
                            <li>부산학아카이브</li>
                        </ul>
                    </li>
                    <li>
                    <ul class="account-container">
                        ${principal == null
                            ? `
                            <li><a href="/account/login">로그인</a></li>
                            <li><a href="/account/register">회원가입</a></li>
                            `
                            : `
                            <li><a href="/admin">${principal.user.name}</a></li>
                            <li><a href="/logout">로그아웃</a></li>
                            `
                        }
                    </ul>
                    </li>
                </ul>
            </div>            
        `;
    }
}

class HeaderService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new HeaderService();
        }
        return this.#instance;
    }

    loadHeader() {
        const headerContainer = document.querySelector(".header-container");
        const principal = PrincipalApi.getInstance().getPrincipal();

        headerContainer.innerHTML = `
            <h1 class="brand-logo"><a href="/index"></a></h1>
            <ul class="menu-container">
                <li><a href="">도서관이용</a></li>
                <li><a href="/search">자료검색</a></li>
                <li><a href="">도서관행사</a></li>
                <li><a href="">책읽는도시부산</a></li>
                <li><a href="">열린공간</a></li>
                <li><a href="">내서재</a></li>
            </ul>
            
        `;
    }
}