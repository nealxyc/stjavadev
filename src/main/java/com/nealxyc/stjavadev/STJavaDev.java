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
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.CompletionRequestor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
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
	
	public List<String> getAllMethods(String javaSrcFullName){
		ArrayList<String> methods = new ArrayList<String>();
		try {
			IType type = activeProject.findType(javaSrcFullName);
			for(IMethod m: type.getMethods()){
				methods.add(m.getElementName());
			}
			
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return methods;
	}
	
	public boolean codeComplete(String filePath, int offset, CompletionRequestor req){
		IJavaProject prj = Utils.notNull(activeProject);
		try {
//			IType type = prj.findType(javaSourcePath);
			IJavaElement elem = prj.findElement(new Path(filePath));
			if(elem != null && elem instanceof ICompilationUnit ){
				ICompilationUnit icu = (ICompilationUnit) elem;
				System.out.println(icu.getSource());
				if(!icu.isOpen()) {
					icu.open(null);
				} else{
					if(icu.hasResourceChanged() ){
						System.out.println("[STJavaDev.codeComplete] resource changed.");
						//icu.makeConsistent(null);
					}
				}
				icu.codeComplete(offset, req);
				return true ;
			}else{
				System.out.println(elem.getResource());
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false ;
	}
	
	
	
}
