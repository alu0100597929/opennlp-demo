
package org.fogbeam.example.opennlp;


import java.io.*;


import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 * 
 * @author Juan Manuel Ramos Perez
 * Modification with readFile() method
 */


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
			
                         /**
                          * call readFile method
                          */
                        String[] tokens = tokenizer.tokenize(readFile("demo_tokens/tokens.txt"));
                        
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
        
        /**
         * readFile method
         * @author Juan Manuel Ramos Perez
         * @param filename
         * @return tokens
         */
        public static String readFile(String filename)
        {
            try
            {
                InputStream is = new FileInputStream(filename);
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
