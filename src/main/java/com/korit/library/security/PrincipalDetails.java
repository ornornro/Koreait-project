package com.korit.library.security;

import com.korit.library.entity.UserMst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
@AllArgsConstructor
public class PrincipalDetails implements UserDetails {

    @Getter
    private final UserMst user;
    private Map<String,Object> response;

    // 권한을 리스트로 관리하는 권한
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

//        List<RoleDtlDto> roleDtlDtoList = user.getRoleDtlDto();
//
//        for(int i = 0; i < roleDtlDtoList.size(); i++) {
//            RoleDtlDto roleDtlDto = roleDtlDtoList.get(i);
//            RoleMstDto roleMstDto = roleDtlDto.getRoleMstDto();
//            String roleName = roleMstDto.getRoleName();
//
//            GrantedAuthority role = new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return roleName;
//                }
//            };
//
//            authorities.add(role);
//
//        }

        // 위 주석을 줄여서 쓰면 아래에 있는 람다식으로 표현가능하다! 위에 식으로 이해하자.. 람다 존나 어려움;;
        user.getRoleDtl().forEach(dtl -> {
            authorities.add(() -> dtl.getRoleMst().getRoleName());
        });

        return authorities; // 권한들이 다 리스트 안으로 들어간다 권한들이 다 들어가는 곳!
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    /*
        계정 만료 여부
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /*
        계정 잠김 여부(=휴먼계정)
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /*
        비밀번호 만료 여부(=비밀번호 여러번 틀렸을때 잠굼)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /*
        사용자 활성화 여부(=전화번호나 이메일 인증을 하지않은 계정을 잠굼)(=여기서도 휴먼계정을 관리가능)
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
