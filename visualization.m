a = importdata('result.txt');
m=size(a,1);
for i=1:1:m
    if a(i,3)==1
        plot(a(i,1),a(i,2),'r.');
    elseif a(i,3)==2
        plot(a(i,1),a(i,2),'b.');
    elseif a(i,3)==3
        plot(a(i,1),a(i,2),'g.');
    elseif a(i,3)==4
        plot(a(i,1),a(i,2),'c.');
    elseif a(i,3)==5
        plot(a(i,1),a(i,2),'y.');
    elseif a(i,3)==6
        plot(a(i,1),a(i,2),'k.');
    elseif a(i,3)==7
        plot(a(i,1),a(i,2),'m.');
    elseif a(i,3)==8
        plot(a(i,1),a(i,2),'Color',[1,0.5,0]);
    elseif a(i,3)==9
        plot(a(i,1),a(i,2),'Color',[0.5,0.5,0.5]);
    elseif a(i,3)==10
        plot(a(i,1),a(i,2),'Color',[0.5,0,0]);
    else
        plot(a(i,1),a(i,2),'k*');   
    end
    hold on;
end
grid on;