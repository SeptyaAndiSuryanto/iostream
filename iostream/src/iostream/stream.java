package iostream;

import java.io.*;
public class stream {
	public void unbuffer () throws IOException{
		FileInputStream in = null;
        FileOutputStream out = null;
        byte [] buf = new byte[10];
        long start = System.nanoTime();
        try {
            in = new FileInputStream("rockabaye.mp3");
            out = new FileOutputStream("outbuffrockabaye.mp3");
            int c;
            while ((c = in.read(buf)) != -1) {
                out.write(buf);
                
            }
            out.flush();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        long finish = System.nanoTime();
        System.out.println("time= "+(finish - start)+ " ns");
		
	}
	
	public void buffer() throws IOException{
		FileInputStream in = null;
		OutputStream out = null;
		BufferedInputStream buin = null;
		BufferedOutputStream buot = null;
        long start = System.nanoTime();
		try{
			in = new FileInputStream("rockabaye.mp3");
			buin = new BufferedInputStream(in,2048);
			out = new FileOutputStream("200outbuffrockabaye.mp3");
			buot = new BufferedOutputStream(out,1024);
			int c;
			while ((c=buin.read()) !=-1){
				buot.write(c);
			}
			buot.flush();
			buot.close();
		}finally {
			if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            long finish = System.nanoTime();
            System.out.println("time= "+(finish - start)+ " ns");

		}
	}
	
	 public static void main(String[] args) throws IOException {
		 stream s = new stream();
		 //s.unbuffer();
		 s.buffer();
	}

}
