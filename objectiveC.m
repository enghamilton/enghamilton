#import <Foundation/Foundation.h>

@interface Example:NSObject { NSString *_txt;}

@property(nonatomic, assign) NSString *txt;

-(void) setTxt:(NSString *) txt;
-(NSString *)txt;
-(void)dealloc;
@end

@implementation Example

-(void) setTxt:(NSString *)txt {
    _txt = txt;
}

-(NSString *)txt {
    return _txt;
}

-(void)dealloc {
    NSLog(@"deallocated Example");
    [super dealloc];
}

@end

@interface Example2:NSObject { Example *_ex; int _num;}

@property(nonatomic, retain) Example *ex;
@property(assign) int num;
-(void) setEx:(Example *) ex;
-(Example *) ex;
-(void)setNum:(int)num;
-(int)num;
-(void)dealloc;

@end

@implementation Example2

-(void)setNum:(int)num {
    _num = num;
}
-(int)num {
    return _num;
}

-(void) setEx:(Example *)ex {
    _ex = ex;
}

-(Example *)ex {
    return _ex;
}

-(void)dealloc {
    NSLog(@"deallocated Example2");
    [super dealloc];
}

@end

int sample();

int main (int argc, const char * argv[])
{
        NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
        NSLog (@"Hello World");
        
        Example *e1 = [[Example alloc] init];
        NSLog(@"Example reference counter : %i", [e1 retainCount]);
        Example2 *e2 = [[Example2 alloc] init];
        NSLog(@"Example2 reference counter : %i", [e2 retainCount]);
        [e2 setEx:e1];
        NSLog(@"Example2 property address : %@", [e2 num]);
        //[e1 retain];
        NSLog(@"Example reference counter : %i", [e1 retainCount]);
        NSLog(@"Example2 reference counter : %i", [e2 retainCount]);
        [e1 release];
        NSLog(@"Example reference counter after release: %i", [e1 retainCount]);
        [e1 release];
        e1 = nil;
        NSLog(@"Example reference counter after release: %i", [e1 retainCount]);
        [e2 release];
        NSLog(@"Example reference counter after release: %i", [e2 retainCount]);
        
        [pool drain];
        return 0;
}

int sample(){
    
    return 0;
}
