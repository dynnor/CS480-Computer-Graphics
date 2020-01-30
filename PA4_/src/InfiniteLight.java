/*
 * InfiniteLight.java
 * 
 * Type of lighting model that models a light source infinitely far away; like the sun
 * 
 * History: December 11th, 2019  Created by Dynnor Shebshaievitz
 * 						 Referencing code by Stan Sclaroff
 */
public class InfiniteLight extends Light {
	public Vector3D direction;
	public ColorType color;
	
	public InfiniteLight(ColorType color, Vector3D direction) {
		this.color = new ColorType(color);
		this.direction = new Vector3D(direction);
		super.lightIsOn = true;
	}
	
	public ColorType applyLight(Material mat, Vector3D v, Vector3D n, Vector3D p) {
		//light rays should be parallel to each other as they arrive at the surface
		//L should be constant everywhere and is not dependent on p 
		ColorType res = new ColorType();
		
		double dot = direction.dotProduct(n);
		
		if (dot > 0.0) {
			if (mat.isDiffuse()) {
				res.r += (float)(dot * mat.get_kdiff().r * color.r);
				res.g += (float)(dot * mat.get_kdiff().g * color.g);
				res.b += (float)(dot * mat.get_kdiff().b * color.b);
				
			}
			
			if (mat.isSpecular()) {
				Vector3D r = direction.reflect(n);
				dot = r.dotProduct(v);
				if (dot > 0.0) {
					res.r += (float)Math.pow((dot * mat.get_kspec().r * color.r), mat.get_specularExp());
					res.g += (float)Math.pow((dot * mat.get_kspec().g * color.g), mat.get_specularExp());
					res.b += (float)Math.pow((dot * mat.get_kspec().b * color.b), mat.get_specularExp());
				}
			}
			
			// Clamp
			res.r = (float)Math.min(1.0, res.r);
			res.g = (float)Math.min(1.0, res.g);
			res.b = (float)Math.min(1.0, res.b);
		}
		return(res);
	}
	
	public void toggleLight() {
		lightIsOn = !lightIsOn;
	}
}