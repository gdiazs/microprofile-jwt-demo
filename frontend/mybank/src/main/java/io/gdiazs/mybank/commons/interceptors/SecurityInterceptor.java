package io.gdiazs.mybank.commons.interceptors;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	private final String USER_COOKIE = "keyRingJWT";
	
	private String appContextPath = null;
	
	private String publicKeyPath;
	
	
	

	public SecurityInterceptor(String applicationContext, String publicKeyResourcePath) {
		this.appContextPath = applicationContext;
		this.publicKeyPath = publicKeyResourcePath;
	}




	/**
	 * Valida que la cookie del navegador tenga el almenos un token
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		String jwt = "";

		String requestURI = request.getRequestURI();

		if (requestURI.contains(this.appContextPath +"/login") || requestURI.contains("resources")
				|| requestURI.contains("errors")) {
			return true;
		}

		if (cookies == null) {
			response.sendRedirect(this.appContextPath +"/login");
			return false;

		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(USER_COOKIE)) {
					jwt = cookie.getValue();
					return isValidToken(jwt);
				}
			}
			request.setAttribute("jwt", jwt);
		}

		return true;

	}
	
	public boolean isValidToken (String jwToken) throws IOException, ParseException, JOSEException {
	    SignedJWT signedJWT = SignedJWT.parse(jwToken);
		JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) readPublicKey());
		return signedJWT.verify(verifier);
		
	}
	
	
    private PublicKey readPublicKey() throws IOException {
    	
    	PEMParser pemParser = null;
    	
    	PublicKey publicKey = null;
    	try {
            InputStream inputStream = SecurityInterceptor.class.getResourceAsStream(this.publicKeyPath);

            pemParser = new PEMParser(new InputStreamReader(inputStream));
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider(new BouncyCastleProvider());
            Object object = pemParser.readObject();
    
            
            publicKey  = converter.getPublicKey((SubjectPublicKeyInfo) object);
    		
    		
    	}finally{
    		if (pemParser != null) {
    			pemParser.close();
    		}
    	}
    	

        return publicKey;
    }


}
