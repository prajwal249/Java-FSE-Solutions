import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Course } from '../models/course.model';

@Injectable({ providedIn: 'root' })
export class CourseService {
  private courses: Course[] = [
    { id: 1, name: 'Angular', code: 'ANG101', credits: 4, gradeStatus: 'passed', enrolled: true },
    { id: 2, name: 'Java', code: 'JAVA101', credits: 4, gradeStatus: 'failed', enrolled: false },
    { id: 3, name: 'SQL', code: 'SQL101', credits: 3, gradeStatus: 'pending', enrolled: false },
    { id: 4, name: 'Spring Boot', code: 'SPR101', credits: 4, gradeStatus: 'passed', enrolled: false },
    { id: 5, name: 'React', code: 'REA101', credits: 3, gradeStatus: 'pending', enrolled: false }
  ];

  getCourses(): Observable<Course[]> {
    return of(this.courses);
  }

  getCourseById(id: number): Observable<Course | undefined> {
    return of(this.courses.find(course => course.id === id));
  }

  getCoursesSync(): Course[] {
    return this.courses;
  }

  addCourse(course: Course): void {
    this.courses.push(course);
  }
}
