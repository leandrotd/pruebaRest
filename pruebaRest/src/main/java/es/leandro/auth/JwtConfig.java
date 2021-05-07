package es.leandro.auth;

public class JwtConfig {
	public static final String LLAVE= "llave.secreta.123";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEA3iguDMsQRYm/myJ9/sB+OQWcpGJb756flC4mTzFXg761/3NV\r\n"
			+ "ImJeP6WBU38L1nZ3sWHsIq788hNeEwbIiH+ZCiE7esr9kWmPa9U3aCFE83GuhUku\r\n"
			+ "pnFo1KXgcF4aXTs20azyCqNyJLPhnXvb8VtT4xE0GxzeBNB7n058Pvxe3OwK/ZHy\r\n"
			+ "zRrikeSXIGXE4SLOZHvB8LK5c7jAOY4MHUpDdF8YwgKVZgwuAgyV0N8H8xB7va+H\r\n"
			+ "/fmDwQ0SA5C7U9kENaosRoXXOhswK/8GTNLx6r5YXYUA6HJYi1Ow1y8WnqUQA7DA\r\n"
			+ "3W6N92kAsJVWVc5BGwj0132eB6MEgR9ck3odKwIDAQABAoIBAQCyGYwxfWoiFXii\r\n"
			+ "qlhQL4oBtNoLfz8tLwHIDedwfaInYHEPxipuUmY0qD6x7ZxT5s22S0a/14G5oIU+\r\n"
			+ "w6VoqMLMODAzFSGLvhDY5ipxNJrOgEjlWfIoRatBL2prK0X/kEU2e2vf04Dio8Mw\r\n"
			+ "Oeft6sWpuFUJl272dR1mbcl1xWVXvfXHVc3P2Xl2Y3zCi8WIerHcpAZvIq3PL3e3\r\n"
			+ "Wzq2CAPgVC07HhzB1jS5m8Am18j+X4/P/TueYY4q9qYyq7qrwxGXPDtHsrwJx45Z\r\n"
			+ "loNDw7lAQ6rWMNjycRmLKQoB04ELV27kKnlVX16gATLN2FV/oD12rDUnX/O1u6Fx\r\n"
			+ "N4E2nvCBAoGBAPbYhKUA+6QN7QyZZPcoaSJqYrvIH2ElyJLcjZY9u7UNmQnJf3K4\r\n"
			+ "oyfAfyMtLARLuokmfrUJrYgJdO1ilcglMHt8lOBBZPKpTCyQdmda6sKittBlDr8B\r\n"
			+ "qhJkBmqcPe3c0wRaieCWBHtSGiD07vHvatK3ITFM42HpzTQkGPTQ3BixAoGBAOZl\r\n"
			+ "RfSafBZ24nUKIPEsKbU36RpVq3gGYm6y/xYJBKLnNkEaLK3G8nRu9jKQP6d+rVRp\r\n"
			+ "o0BQZoGhPEMQzdMBw7xDOAQGTrwBMICDSLWUxQUa8dzcDBShQHfo9eU3CWQDFwJs\r\n"
			+ "qwKo8D3MqLpvGQj5FJvTmAgM7RdFu/lsq7n1VEqbAoGABV/zi3A5CnpvJe4VH7iW\r\n"
			+ "iXRNkA8sd74N3vzEbHgNpUSVh3wGtWXFz7DGU+rA4ZsQhbn72k9KowKptB2Ia2I7\r\n"
			+ "6wRsbXGfFBWRngrLOTbmk7RdTK5WotwTavEYnqumQY6kXZznEafSkyjXfs42gbgX\r\n"
			+ "2Fy6cUteTBx+Jlt+253MnRECgYA9tSg8cFgF6EeVE2ZpUevF1ri/TezEE+mvPo/l\r\n"
			+ "xfqQ6x5z51/KF3v+xW15c3spEFu6PST1Z9NcquOqDskh19omBVbudQYHgsYL1Z3W\r\n"
			+ "zIbMbEAVaHZv3BSZSTL69ne0asNx6csPxlG6K6ORc4ogBh6H8e9JULT7w7iqAHoq\r\n"
			+ "L1QpOwKBgHVDSsRGIUfHLkD1s8ZG3W9Yr8/yt8KMCZgFIjr9m93GV8g/oHe8ofrn\r\n"
			+ "viF04VOzo+kJKKx57CTHdnBIGpOiIs763Cr97+Sm0LWbL2lszdOYRtKfivWBz60/\r\n"
			+ "DHW1DmYyTk7YvtGGPnFrt/SEveCA++E+RWfGRwfayqfYx5aJHW2g\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3iguDMsQRYm/myJ9/sB+\r\n"
			+ "OQWcpGJb756flC4mTzFXg761/3NVImJeP6WBU38L1nZ3sWHsIq788hNeEwbIiH+Z\r\n"
			+ "CiE7esr9kWmPa9U3aCFE83GuhUkupnFo1KXgcF4aXTs20azyCqNyJLPhnXvb8VtT\r\n"
			+ "4xE0GxzeBNB7n058Pvxe3OwK/ZHyzRrikeSXIGXE4SLOZHvB8LK5c7jAOY4MHUpD\r\n"
			+ "dF8YwgKVZgwuAgyV0N8H8xB7va+H/fmDwQ0SA5C7U9kENaosRoXXOhswK/8GTNLx\r\n"
			+ "6r5YXYUA6HJYi1Ow1y8WnqUQA7DA3W6N92kAsJVWVc5BGwj0132eB6MEgR9ck3od\r\n"
			+ "KwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
