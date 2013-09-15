package ttl.client;

public class Settings 
{
	// Available Views:
	public final static int ANONYMOUS_VIEW = 0;
	public final static int WELCOME_VIEW = 1;
	public final static int ACCOUNT_VIEW = 2;
	
	// Misc. Settings
	public static int DEFAULT_ANIMATION_TIME = 450;
	public static int DEFAULT_ANIMATION_FADE_TIME = 450;
	
	private Settings()
	{
		throw new AssertionError();
	}
}
