package annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// most of the Annotations we use are pre-defined annotations like @Override
// However this is an example of user-defined Annotation
// Annotations provide a way to maintain information in Java
// Comments are another way to maintain information in Java
// However, comments don't reach Compiler, JVM levels, only Developer level
// if we want the info to reach Compiler, JVM, SpringBoot and Developer levels, we need Annotations
// when we create a user-defined Annotation, we use meta annotations like @Retention, @Target
// @Retention specifies what levels to reach
// @Target specifies where this Annotation is applicable. For example, @Override can be only applied to methods(), not classes

@Retention(RetentionPolicy.RUNTIME) // the reach is until Compiler level 
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.METHOD}) // now i can apply to Constructor, local variable, method etc 
@interface Player{
	int age() default 35;
	String country() default "USA";
	
}//@ now Java compiler understands it's an Annotation being created

@Player
class ChessPlayer{
	int games;
	
	@Player
	public ChessPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Player
	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}
	
}


public class UserdefinedAnnotations {


	public static void main(String[] args) {
		ChessPlayer cp = new ChessPlayer();
		cp.setGames(55);
		System.out.println(cp.getGames());
		
		Class <? extends ChessPlayer> cl = cp.getClass(); // cl is like a Child class of ChessPlayer
		Annotation an = cl.getAnnotation(Player.class); // Annotation is the parent of all Annotations
		Player pl = (Player) an;
		int age = pl.age();
		String country = pl.country();
		System.out.println("Player Age is: "+age + " Country is: "+country);

	}

}
