package com.GabrielMJr.Twaire.AllEasy.tools;

public class Tools implements ToolsManager
{
	
		/* Método que retorna se o valor é nulo ou não
		 if null, return true
		 else, return false
		 */
		@Override
		public Boolean isNull(String val)
			{
				String v = String.valueOf(val);
				switch (v)
					{
						case "":
							return true;

						default:
							return false;
					}
			}
}

