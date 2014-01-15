import org.eclipse.jdt.core.CompletionRequestor

class CompletionRequestor(org.eclipse.jdt.core.CompletionRequestor):
    def __init__(self):

        self.completions = []
        pass
    
    def accept(self, proposal):
#         print 'Completion accepted:'
#         print proposal
        print proposal.getName().tostring()
        print proposal.getCompletion().tostring()
        print proposal.getSignature().tostring()
#         print
#         self.completions.append((proposal.getName(), proposal.getCompletion(), proposal))            
        
         
if __name__ == '__main__':
    pass
