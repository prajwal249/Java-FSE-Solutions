import { Component, OnInit } from '@angular/core';
import { CourseCard } from '../../components/course-card/course-card';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CourseCard, CommonModule],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {
  courses: Course[] = [];
  isLoading = true;
  selectedCourseId = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit() {
    this.courses = this.courseService.getCoursesSync();
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  trackByCourseId(index: number, course: Course) {
    return course.id;
  }

  onCourseEnroll(courseId: number) {
    this.selectedCourseId = courseId;
    console.log('Enrolling in course:', courseId);
  }
}
