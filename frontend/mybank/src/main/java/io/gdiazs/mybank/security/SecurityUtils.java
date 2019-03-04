package io.gdiazs.mybank.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;

public final class SecurityUtils {

	public static final String USER_COOKIE = "keyRingJWT";

	public static boolean isValidToken(String jwToken, String publicKeyPath)
			throws IOException, ParseException, JOSEException {
		final SignedJWT signedJWT = parseJWT(jwToken);
		final JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) SecurityUtils.readPublicKey(publicKeyPath));
		return signedJWT.verify(verifier);

	}

	public static SignedJWT parseJWT(String jwToken) throws ParseException, IOException {
		final SignedJWT signedJWT = SignedJWT.parse(jwToken);
		return signedJWT;
	}

	public static String getJWT(HttpServletRequest request) {
		String jwt = null;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(SecurityUtils.USER_COOKIE)) {
				jwt = cookie.getValue();
				return jwt;
			}
		}

		return jwt;

	}

	public static PublicKey readPublicKey(String publicKeyPath) throws IOException {

		PEMParser pemParser = null;

		PublicKey publicKey = null;
		try {
			InputStream inputStream = SecurityInterceptor.class.getResourceAsStream(publicKeyPath);

			pemParser = new PEMParser(new InputStreamReader(inputStream));
			JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider(new BouncyCastleProvider());
			Object object = pemParser.readObject();

			publicKey = converter.getPublicKey((SubjectPublicKeyInfo) object);

		} finally {
			if (pemParser != null) {
				pemParser.close();
			}
		}

		return publicKey;
	}
}
