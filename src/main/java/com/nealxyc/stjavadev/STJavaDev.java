package com.nealxyc.stjavadev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class STJavaDev {
	
	IWorkspaceRoot root ;
	
	IJavaProject activeProject ;
	HashMap<String, IJavaProject> projectMap ;
	
	public STJavaDev(){
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
	    this.root = workspace.getRoot();
	}
	
	public STJavaDev(String projectName){
		this();
	    focusProject(projectName);
	}
	
	public boolean focusProject(String projectName){
		 // Get all projects in the workspace
	    IProject[] projects = root.getProjects();
	    for (IProject project : projects){
	    	try {
				if (project.getName().equals(projectName) && project.isNatureEnabled("org.eclipse.jdt.core.javanature")){
					this.activeProject = JavaCore.create(project);
					return true ;
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return false ;
	}
	
	public boolean openWorkspace(String folder){
		return false ;
	}
	
	public List<String> getAllMethods(String javaSourcePath){
		ArrayList<String> methods = new ArrayList<String>();
		try {
			IType type = activeProject.findType(javaSourcePath);
			for(IMethod m: type.getMethods()){
				methods.add(m.getElementName());
			}
			
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return methods;
	}
	
	
}
