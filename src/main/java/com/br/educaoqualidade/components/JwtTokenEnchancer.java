package com.br.educaoqualidade.components;

import com.br.educaoqualidade.model.Usuario;
import repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class JwtTokenEnchancer implements TokenEnhancer {

    @Autowired
    private UsuarioRepository userRepository;


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Usuario usuario = userRepository.findByEmail(authentication.getName());
        Map<String, Object> map = new HashMap<>();
        map.put("userName", usuario.getUsername());
        map.put("userId", usuario.getId());

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(map);

        return accessToken;
    }
}
