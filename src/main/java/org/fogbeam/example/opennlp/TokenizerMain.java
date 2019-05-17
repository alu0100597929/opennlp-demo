
package org.fogbeam.example.opennlp;


//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
import java.io.*;


import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class TokenizerMain
{
	public static void main( String[] args ) throws Exception
	{
		
		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );

		
		// the model we trained
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		
		try
		{
			TokenizerModel model = new TokenizerModel( modelIn );
		
			Tokenizer tokenizer = new TokenizerME(model);
			
				/* note what happens with the "three depending on which model you use */
			/*
                        String[] tokens = tokenizer.tokenize
					(  "A ranger journeying with Oglethorpe, founder of the Georgia Colony, " 
							+ " mentions \"three Mounts raised by the Indians over three of their Great Kings" 
							+ " who were killed in the Wars.\"" );
			*/
                        String[] tokens = tokenizer.tokenize(readFile());
                        
			for( String token : tokens )
			{
				System.out.println( token );
			}
			
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch( IOException e )
				{
				}
			}
		}
		System.out.println( "\n-----\ndone" );
	}
        
        public static String readFile()
        {
            try
            {
                InputStream is = new FileInputStream("demo_tokens/tokens.txt");
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));

                String line = bf.readLine();
                StringBuilder sb = new StringBuilder();

                while(line != null)
                {
                    sb.append(line).append("\n");
                    line = bf.readLine();
                }
                String tokens = sb.toString();
                return tokens;
            }
            catch(Exception e)
            {
                return null;
            }  
        }
}
