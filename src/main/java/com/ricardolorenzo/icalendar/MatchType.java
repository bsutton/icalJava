package com.ricardolorenzo.icalendar;

import java.util.Map;

public enum MatchType
{
	
    EQUALS("equals") {
		@Override
		public <T> T match(Map<String, T> map, String uid)
		{
			T result = null;
			if ((uid != null) && map.containsKey(uid)) {
			    result = map.get(uid);
			}
			return result;
		}
	} // an exact match to the target string

    , CONTAINS("contains") {
		@Override
		public <T> T match(Map<String, T> map, String uid)
		{
			T result = null;
			if (uid != null) 
			{
				for (String key : map.keySet().toArray(new String[]{}))
				{
					if (key.contains(uid))
					{
						result = map.get(key);
						break;
					}
				}
			}
			return result;
		}
	} // a substring match, matching anywhere within the target string

    , STARTS_WITH("starts-with") {
		@Override
		public <T> T match(Map<String, T> map, String uid)
		{
			T result = null;
			if (uid != null) 
			{
				for (String key : map.keySet().toArray(new String[]{}))
				{
					if (key.startsWith(uid))
					{
						result = map.get(key);
						break;
					}
				}
			}
			return result;
		}

	} // a substring match, matching only at the start of the target string

    , ENDS_WITH("ends-with") {
		@Override
		public <T> T match(Map<String, T> map, String uid)
		{
			T result = null;
			if (uid != null) 
			{
				for (String key : map.keySet().toArray(new String[]{}))
				{
					if (key.endsWith(uid))
					{
						result = map.get(key);
						break;
					}
				}
			}
			return result;
		}
	}

	// a substring match, matching only at the end of the target string
    ;
    
    private String matchTypeString;
    
    MatchType(String matchTypeString)
    {
    	this.matchTypeString = matchTypeString;
    }

	public abstract <T>  T match(Map<String, T> vtodo, String uid);
	
	static public MatchType getEnum(String matchTypeString)
	{
		MatchType result = null;
		
		for (MatchType matchType : MatchType.values())
		{
			if (matchType.matchTypeString.equals(matchTypeString))
			{
				result = matchType;
				break;
			}
		}
		return result;
	}

}
